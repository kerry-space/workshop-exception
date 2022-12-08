package se.lexicon.exceptions.workshop;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.Exceptions.DuplicateNameException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Gender;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List <String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames,lastNames);


        Person test = nameService.getNewRandomPerson();
        System.out.println(ConsoleColors.BLUE+test+ConsoleColors.RESET);

        //object person



        try {

            nameService.addMaleFirstName("one");
            nameService.addLastName("test");

            System.out.println(ConsoleColors.GREEN+"added"+ConsoleColors.RESET);


        } catch (DuplicateNameException e) {
            System.out.println("MessageError: "+e.getMessage()+" "+"ParaValue: "+e.getParamValue());
        }

    }

}
