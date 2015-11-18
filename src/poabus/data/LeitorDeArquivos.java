package poabus.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import poabus.domain.Linha;
import poabus.domain.Parada;

public class LeitorDeArquivos {

    static void LerArquivos(ArrayList<Parada> paradas, ArrayList<Linha> linhas) {
        lerParadas(paradas);
        lerLinhas(linhas);
        definirRelacionamentos(linhas, paradas);
    }

    private static void lerParadas(ArrayList<Parada> paradas) {
        ArrayList<String> dadosParada = new ArrayList<String>();

        try {
            File paradaCsv = new File("paradas.csv");
            Scanner leitor = new Scanner(paradaCsv);
            leitor.nextLine();
            while (leitor.hasNext()) {
                dadosParada.add(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        try {
            Parada p1;
            for (String s : dadosParada) {
                String[] d = s.split(";");
                p1 = new Parada();
                p1.setId(Integer.parseInt(d[0]));

                NumberFormat nf = NumberFormat.getInstance();
                double lat = nf.parse(d[3]).doubleValue();

                p1.setLatitude(lat);

                double lon = nf.parse(d[2]).doubleValue();
                p1.setLongitude(lon);

                paradas.add(p1);
            }
        } catch (ParseException e) {
            System.out.println("Banco corrompido! " + e.getMessage());
        }
    }

    private static void lerLinhas(ArrayList<Linha> linhas) {

        ArrayList<String> dadosLinha = new ArrayList<String>();
        try {
            File linhaCsv = new File("linhas.csv");
            Scanner leitor = new Scanner(linhaCsv);
            leitor.nextLine();
            while (leitor.hasNext()) {
                dadosLinha.add(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        Linha l1;
        for (String s : dadosLinha) {
            String[] d = s.split(";");
            l1 = new Linha();
            l1.setId(Integer.parseInt(d[0]));
            l1.setNome(d[1]);
            l1.setTipo(d[3].charAt(1));

            linhas.add(l1);
        }
    }

    private static void definirRelacionamentos(ArrayList<Linha> linhas, ArrayList<Parada> paradas) {
        ArrayList<String> dadosRelacionamento = new ArrayList<String>();
        try {
            File relacionamentosCsv = new File("paradalinha.csv");
            Scanner leitor = new Scanner(relacionamentosCsv);
            leitor.nextLine();
            while (leitor.hasNext()) {
                dadosRelacionamento.add(leitor.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        for (String dados : dadosRelacionamento) {
            String[] dado = dados.split(";");
            Linha linha = getLinhaById(linhas, Integer.parseInt(dado[0]));
            Parada parada = getParadaById(paradas, Integer.parseInt(dado[1]));

            List<Parada> paradasDaLinha = linha.getParadas();
            paradasDaLinha.add(parada);

            if (parada != null) {
                List<Linha> linhasDaParada = parada.getLinhas();
                linhasDaParada.add(linha);
            }
        }

    }

    private static Parada getParadaById(ArrayList<Parada> paradas, int id) {
        for (Parada par : paradas) {
            if (par.getId() == id) {
                return par;
            }
        }
        return null;
    }

    private static Linha getLinhaById(ArrayList<Linha> linhas, int id) {
        for (Linha lin : linhas) {
            if (lin.getId() == id) {
                return lin;
            }
        }
        return null;
    }
}
