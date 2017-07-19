package thiago.crawler;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import thiago.dao.PlacaDAO;
import thiago.model.Placa;

/**
 * @author thiago.f.v.silva@gmail.com
 * 
 * Busca no site www.clubedetran.com.br, informações sobre 
 * as placas do tipo regulamentação e placas do tipo advertência,
 * e salva essas informações numa base de dados.
 *
 */

public class CrawlerRegulamentacaoAdvertencia {
	
	public static void main(String[] args) throws IOException, SQLException {
		
		PlacaDAO placaDao = new PlacaDAO();
		
		String[] tiposDePlacas = {"placas-de-regulamentacao", "placas-de-advertencia"};
			
		for (String tipoDePlaca : tiposDePlacas) {
			
			String url = "https://clubedetran.com.br/" + tipoDePlaca;
			
			Document doc = Jsoup.connect(url).get();
			
			Element mainDiv = doc.getElementById("c_panPlacas");
			
			Elements childrens = mainDiv.children();
			
			for (Element children : childrens) {
				Placa placa = new Placa();
				placa.setSigla(children.getElementsByTag("strong").get(0).text());
				placa.setTitulo(children.getElementsByTag("h4").get(0).text());
				placa.setDescricao(children.getElementsByTag("p").get(0).text());
				placa.setImagem(children.getElementsByTag("img").get(0).attr("src"));
				placaDao.salvar(placa);
				System.out.println(placa.getImagem());
			}
		}
		
	}
}
