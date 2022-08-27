package com.fdmgroup.com.SpringSoloProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.fdmgroup.com.SpringSoloProject.controller.RecordController;
import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Record;
import com.fdmgroup.com.SpringSoloProject.service.MemberService;
import com.fdmgroup.com.SpringSoloProject.service.RecordService;

@ExtendWith(MockitoExtension.class)
public class RecordControllerTest {


	private RecordService recordService;
	
	@Mock
	private MemberService memberServiceMock;

	@Mock
	private Model modelMock;
	
    @Autowired
    private RecordRepository recordRepository;

	private RecordController recordController;

	@BeforeEach
	public void setup() {
		recordController = new RecordController(memberServiceMock, recordService);
		recordService = new RecordService(recordRepository);

	}
	@Test
    public void test_viewMyRrcords() {
        List<Record> listRecords = recordService.findByMemberId(1L);
        assertThat(listRecords.get(0).getRecordId().equals(1L));
    }


//	@Test
//	void test_getMoviesPage_returnsCorrectView() {
//		// Arrange
//		String expected = "Movies";
//		// Action
//		String actual = movieController.getMoviesPage(modelMock);
//		// Assert
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void test_getMoviesPageById_returnsCorrectView() {
//		// Arrange
//		String expected = "Movie";
//		// Action
//		String actual = movieController.getMoviesPageById(0L, modelMock);
//		// Assert
//		assertEquals(expected, actual);
//
//	}
//
//	@Test
//	void test_addMovieForm_returnsCorrectView() {
//		// Arrange
//		String expected = "editMovie";
//		// Action
//		String actual = movieController.addMovieForm(modelMock);
//		// Assert
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void test_saveMovie_returnsCorrectView() {
//		// Arrange
//		String expected = "redirect:/all";
//		// Action
//		Movie movie = new Movie();
//		String actual = movieController.saveMovie(movie);
//		// Assert
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void test_showUpdateForm_returnsCorrectView() {
//		// Arrange
//		String expected = "editMovie";
//		// Action
//		String actual = movieController.showUpdateForm(modelMock, 0L);
//		// Assert
//		assertEquals(expected, actual);
//	}
//
//	@Test
//	void test_deleteMovie_returnsCorrectView() {
//		// Arrange
//		String expected = "redirect:/all";
//		// Action
//		String actual = movieController.deleteMovie(0L);
//		// Assert
//		assertEquals(expected, actual);
//	}

}
