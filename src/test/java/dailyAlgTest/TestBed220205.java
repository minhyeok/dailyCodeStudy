package dailyAlgTest;

import java.io.File;

import org.junit.jupiter.api.Test;


public class TestBed220205 {
	@Test 
    public void testSomeLibraryMethod() {
		LibsForSpecialCase20220205 solv = new LibsForSpecialCase20220205();
        File inFile = new File("src/test/resources/TestFile.txt");
        File outFile = new File("src/test/resources/TestWrite.txt");
        
        solv.solution(inFile, outFile);
        
    }
}
