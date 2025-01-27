package br.com.alura.screemmatch;

import br.com.alura.screemmatch.model.DadosSerie;
import br.com.alura.screemmatch.service.ConsumoApi;
import br.com.alura.screemmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreemmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			var consumoApi = new ConsumoApi();
			var json = consumoApi.obterDados("http://www.omdbapi.com/?t=elite&apikey=3471a212");
			System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}
