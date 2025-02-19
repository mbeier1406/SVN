package com.github.mbeier1406.svm.prg.parser;

import static com.github.mbeier1406.svm.prg.lexer.SVMLexer.SYM_TOKEN_CODE;
import static com.github.mbeier1406.svm.prg.lexer.SVMLexer.SYM_TOKEN_DATA;
import static com.github.mbeier1406.svm.prg.parser.SectionDataParserShortTest.STD_LINE_INFO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.github.mbeier1406.svm.SVMException;
import com.github.mbeier1406.svm.prg.SVMProgram;
import com.github.mbeier1406.svm.prg.SVMProgram.Data;
import com.github.mbeier1406.svm.prg.SVMProgram.Label;
import com.github.mbeier1406.svm.prg.SVMProgram.LabelType;
import com.github.mbeier1406.svm.prg.SVMProgramShort;
import com.github.mbeier1406.svm.prg.lexer.SVMLexer;
import com.github.mbeier1406.svm.prg.lexer.SVMLexer.LineInfo;
import com.github.mbeier1406.svm.prg.lexer.SVMLexer.Symbol;
import com.github.mbeier1406.svm.prg.lexer.SVMLexer.Token;

/**
 * Tests für die Klasse {@linkplain SectionCodeParserShort}.
 */
public class SectionCodeParserShortTest {

	public static final Logger LOGGER = LogManager.getLogger(SectionCodeParserShortTest.class);

	/** Das zu testende Objekt */
	public final SectionCodeParser<Short> sectionCodeParser = new SectionCodeParserShort();

	/** Das zu erstellende Programm */
	public final SVMProgram<Short> svmProgramm = new SVMProgramShort();


	/** Stellt sicher, dass der Startindex >= 0 ist */
	@Test
	public void testeStartIndexKleinerNull() {
		var ex = assertThrows(SVMException.class, () -> sectionCodeParser.parse(svmProgramm, STD_LINE_INFO, -1));
		assertThat(ex.getLocalizedMessage(), containsString("Der Startindex muss zwischen 0 und"));
	}

	/** Stellt sicher, dass der Startindex < Länge InfoList ist */
	@Test
	public void testeStartIndexKleinerGroesserGleichInfoList() {
		var ex = assertThrows(SVMException.class, () -> sectionCodeParser.parse(svmProgramm, STD_LINE_INFO, 1));
		assertThat(ex.getLocalizedMessage(), containsString("Der Startindex muss zwischen 0 und 0 liegen"));
	}


}
