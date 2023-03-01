package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Programm {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o acaminho do seu arquivo: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		List<Product> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] datas = line.split(",");
				String name = datas[0];
				int quantity = Integer.parseInt(datas[2]);
				double value = Double.parseDouble(datas[1]);

				Product products = new Product(name, quantity, value);
				list.add(products);

				line = br.readLine();

			}
			
			boolean sucess = new File(path.getParent() + "\\out").mkdir();
			if (sucess) {
				System.out.println("Pasta criada com sucesso");
			}
			
			File summary = new File("c:\\temp\\out\\sumary.csv");

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary, true))) { // sem true ele reescreve o
																							// arquivo, com true ele
																							// adiciona os novos textos
				for (Product p : list) {

					bw.write(p.toString());
					bw.newLine();
				}
				System.out.println(summary+" criado com sucesso");
			}

			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		

		sc.close();

	}

}