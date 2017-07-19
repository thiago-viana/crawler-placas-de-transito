package thiago.crawler;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import thiago.dao.PlacaDAO;
import thiago.model.Placa;

public class CrawlerServicosAuxiliares {

	public static void main(String[] args) throws IOException, SQLException {
		
		PlacaDAO placaDao = new PlacaDAO();
		
		String url = "https://clubedetran.com.br/placas-de-servicos-auxiliares";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements childrens = doc.getElementsByAttributeValueContaining("class", "c06 ite");
		
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
