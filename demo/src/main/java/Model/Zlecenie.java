package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;
public class Zlecenie {

    private long id;
    private Date dataPrzyjeciaZlecenia;
    private Date dataRealizacjiZlecenia;
    private List<Mebel> meble;

    private double koszt;
    private boolean zrealizowano;
    private Faktura faktura;

    private List<Akcesorium> listaAkcesoriow;
    private List<Element> listaMaterialow;

    public Zlecenie(long id, Date dataPrzyjeciaZlecenia) {
        this.id = id;
        this.dataPrzyjeciaZlecenia = dataPrzyjeciaZlecenia;
        this.listaAkcesoriow = new ArrayList<>();
        this.listaMaterialow = new ArrayList<>();
    }

    public void setMeble(List<Mebel> meble) {
        this.meble = meble;
    }

    public List<Mebel> getMeble(){
        return meble;
    }

    public void obliczMaterial() {
        for (Mebel mebel : meble) {
            mebel.obliczMaterial();

            listaAkcesoriow.addAll(mebel.getAkcesoria());
            listaMaterialow.addAll(mebel.getElementy());
        }
    }

    public void generujPDF(String sciezkaDoPliku) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);
            float lineSpacing = 12f;
            int lp = 1;
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(100, 700);

            contentStream.showText("Wykaz elementow i ich wymiarow:");
            contentStream.newLineAtOffset(0, -lineSpacing);
            contentStream.showText("Lp");
            contentStream.newLineAtOffset(30, 0);
            contentStream.showText("Typ");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Kolor");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Ilosc");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Szerokosc");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Wysokosc");
            contentStream.newLineAtOffset(80, 0);
            contentStream.showText("Grubosc");
            contentStream.newLineAtOffset(-530f, -lineSpacing);

            for (Element element : listaMaterialow) {
                contentStream.newLineAtOffset(100, -lineSpacing);
                contentStream.showText(String.valueOf(lp++));
                contentStream.newLineAtOffset(30, 0);
                contentStream.showText(element.getTyp());
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(element.getKolor());
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(String.valueOf(element.getIlosc()));
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(String.valueOf(element.getSzerokosc()));
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(String.valueOf(element.getWysokosc()));
                contentStream.newLineAtOffset(80, 0);
                contentStream.showText(String.valueOf(element.getGrubosc()));
                contentStream.newLineAtOffset(-530f, -lineSpacing);
            }

            contentStream.endText();
            contentStream.close();

            document.save(sciezkaDoPliku);
            document.close();

            System.out.println("PDF został wygenerowany pomyslnie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
