package demo.aconex;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static demo.aconex.CreateXMLFileJava.xmlFilePath;

/**
 * Created by anya on 11/5/17.
 */
public class Converter {
    public static final String xmlFilePath = "gedcom.xml";
    public static void main(String[] args) {
        List<GEDCOMModel> gedList= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("gedcom.txt"))) {
            String line;
            String brit;
            boolean chan=false;
            boolean checkList= false;
            int count=0;
            int lineCount=0;

            GEDCOMModel gedcomModel=null;
            while ((line = br.readLine()) != null) {

                if(line.split(" ")[0].contains("0")){
                    gedcomModel= new GEDCOMModel();
                    lineCount++;
                }
                if(line.contains("CHAN")){
                    chan=true;
                }
                if(chan==true && line.contains("DATE")){
                    line=line.replace("DATE", "CHAN");
                    chan=false;
                }
                findDocument(line,gedcomModel);
                if((lineCount-count)==1){
                    gedList.add(gedcomModel);
                    count=lineCount;
                }
            }
            System.out.println(gedcomModel);
            System.out.println("=======================");
            System.out.println(gedList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        generateXML(gedList);


    }

    public static void findDocument(String line,  GEDCOMModel gedcomModel){

        String split[]=line.split(" ");
        if(split[0].equals("0")){
            gedcomModel.setIndi(split[1]);
        }if(split[0].equals("1")){
            if(split[1].equals("NAME")) {
                gedcomModel.setName(split[2]);
            }if(split[1].equals("SEX")){
                gedcomModel.setSex(split[2]);
            }if(split[1].equals("OCCU")){
                gedcomModel.setOccu(split[2]);
            } if(split[1].equals("TITL")){
                gedcomModel.setTitl(split[2]);
            }if(split[1].equals("FAMC")){
                gedcomModel.setFamc(split[2]);
            }if(split[1].equals("FAMS")){
                gedcomModel.setFams(split[2]);
            }if(split[1].equals("NOTE")){
                gedcomModel.setNote(split[2]);
            }if(split[1].equals("BIRT")){
                gedcomModel.setBrit(new BirthDate(null, null));
            }if(split[1].equals("CHAN")){
                gedcomModel.setChan(new BirthDate(null));
            }

        }if(split[0].equals("2")){
            if(split[1].equals("DATE") ) {
                StringBuffer date = getActualval(split);
                gedcomModel.getBrit().setDate(date.toString());
                date.delete(0, date.length());
            }if(split[1].equals("PLAC")) {
                StringBuffer place = getActualval(split);
                gedcomModel.getBrit().setPlace(place.toString());
                place.delete(0, place.length());
            }if(split[1].equals("CHAN") ) {
                StringBuffer date = getActualval(split);
                gedcomModel.getChan().setDate(date.toString());
                date.delete(0, date.length());
            }
        }


    }

    private static StringBuffer getActualval(String[] split) {
        int len=split.length;
        StringBuffer date = new StringBuffer();
        for(int j=2; j<len; j++){
            date.append(split[j]);
            date.append(" ");
        }
        return date;
    }

    private static void generateXML(List<GEDCOMModel> gedList) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("gedcom");
            for (GEDCOMModel gedcomModel:gedList) {
                createDocument(document, root,gedcomModel);
            }
            document.appendChild(root);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void createDocument(Document document,Element root, GEDCOMModel gedcomModel) {
        // root element
//        Element root = document.createElement("gedcom");


        // employee element
        Element indi = document.createElement("indi");

        root.appendChild(indi);

        // set an attribute to staff element
        Attr attr = document.createAttribute("id");
        attr.setValue(gedcomModel.getIndi());
        indi.setAttributeNode(attr);
        // firstname element
        Element name = document.createElement("name");
        name.appendChild(document.createTextNode(gedcomModel.getName()));

        Element sex = document.createElement("sex");
        sex.appendChild(document.createTextNode(gedcomModel.getSex()));
        Element brit=document.createElement("BRIT");
        Element date= document.createElement("DATE");
        date.appendChild(document.createTextNode(gedcomModel.getBrit().getDate()));
        brit.appendChild(date);

        Element place= document.createElement("PLACE");
        String place1 = gedcomModel.getBrit().getPlace();
        place.appendChild(document.createTextNode(place1 !=null?place1:"NULL"));
        brit.appendChild(place);




        indi.appendChild(name);
        indi.appendChild(sex);
        indi.appendChild(brit);
        if(gedcomModel.getOccu()!=null){
            Element occu = document.createElement("OCCU");
            occu.appendChild(document.createTextNode(gedcomModel.getOccu()));
            indi.appendChild(occu);
        } if(gedcomModel.getTitl()!=null){
            Element titl = document.createElement("TITL");
            titl.appendChild(document.createTextNode(gedcomModel.getTitl()));
            indi.appendChild(titl);
        }
        if(gedcomModel.getFamc()!=null){
            Element famc = document.createElement("FAMC");
            famc.appendChild(document.createTextNode(gedcomModel.getFamc()));
            indi.appendChild(famc);
        }
        if(gedcomModel.getFams()!=null){
            Element fams = document.createElement("FAMS");
            fams.appendChild(document.createTextNode(gedcomModel.getFams()));
            indi.appendChild(fams);
        }
        if(gedcomModel.getChan()!=null){
            Element chan=document.createElement("CHAN");
            Element chanDate= document.createElement("DATE");
            date.appendChild(document.createTextNode(gedcomModel.getChan().getDate()));
            brit.appendChild(chanDate);
        }
    }

}


class GEDCOMModel{
    private  String indi;
    private  String name;
    private String sex;
    private BirthDate brit;
    private String occu;
    private String titl;
    private String famc;
    private String fams;
    private String note;
    private BirthDate chan;

    public GEDCOMModel() {

    }

    public GEDCOMModel(String indi, String name, String sex, BirthDate brit, String occu, String titl, String famc, String fams, String note, BirthDate chan) {
        this.indi = indi;
        this.name = name;
        this.sex = sex;
        this.brit = brit;
        this.occu = occu;
        this.titl = titl;
        this.famc = famc;
        this.fams = fams;
        this.note = note;
        this.chan = chan;
    }

    public String getIndi() {
        return indi;
    }

    public void setIndi(String indi) {
        this.indi = indi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BirthDate getBrit() {
        return brit;
    }

    public void setBrit(BirthDate brit) {
        this.brit = brit;
    }

    public String getOccu() {
        return occu;
    }

    public void setOccu(String occu) {
        this.occu = occu;
    }

    public String getTitl() {
        return titl;
    }

    public void setTitl(String titl) {
        this.titl = titl;
    }

    public String getFamc() {
        return famc;
    }

    public void setFamc(String famc) {
        this.famc = famc;
    }

    public String getFams() {
        return fams;
    }

    public void setFams(String fams) {
        this.fams = fams;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BirthDate getChan() {
        return chan;
    }

    public void setChan(BirthDate chan) {
        this.chan = chan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GEDCOMModel)) return false;

        GEDCOMModel that = (GEDCOMModel) o;

        if (getIndi() != null ? !getIndi().equals(that.getIndi()) : that.getIndi() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSex() != null ? !getSex().equals(that.getSex()) : that.getSex() != null) return false;
        if (getBrit() != null ? !getBrit().equals(that.getBrit()) : that.getBrit() != null) return false;
        if (getOccu() != null ? !getOccu().equals(that.getOccu()) : that.getOccu() != null) return false;
        if (getTitl() != null ? !getTitl().equals(that.getTitl()) : that.getTitl() != null) return false;
        if (getFamc() != null ? !getFamc().equals(that.getFamc()) : that.getFamc() != null) return false;
        if (getFams() != null ? !getFams().equals(that.getFams()) : that.getFams() != null) return false;
        if (getNote() != null ? !getNote().equals(that.getNote()) : that.getNote() != null) return false;
        return getChan() != null ? getChan().equals(that.getChan()) : that.getChan() == null;
    }

    @Override
    public int hashCode() {
        int result = getIndi() != null ? getIndi().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getBrit() != null ? getBrit().hashCode() : 0);
        result = 31 * result + (getOccu() != null ? getOccu().hashCode() : 0);
        result = 31 * result + (getTitl() != null ? getTitl().hashCode() : 0);
        result = 31 * result + (getFamc() != null ? getFamc().hashCode() : 0);
        result = 31 * result + (getFams() != null ? getFams().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        result = 31 * result + (getChan() != null ? getChan().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GEDCOMModel{" +
                "indi='" + indi + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", brit=" + brit +
                ", occu='" + occu + '\'' +
                ", titl='" + titl + '\'' +
                ", famc='" + famc + '\'' +
                ", fams='" + fams + '\'' +
                ", note='" + note + '\'' +
                ", chan=" + chan +
                '}';
    }
}

class BirthDate {
    private String date;
    private String place;

    public BirthDate(String date) {
        this.date = date;
    }

    public BirthDate(String date, String place) {
        this.date = date;
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthDate)) return false;

        BirthDate birthDate = (BirthDate) o;

        if (getDate() != null ? !getDate().equals(birthDate.getDate()) : birthDate.getDate() != null) return false;
        return getPlace() != null ? getPlace().equals(birthDate.getPlace()) : birthDate.getPlace() == null;
    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getPlace() != null ? getPlace().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "date='" + date + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}