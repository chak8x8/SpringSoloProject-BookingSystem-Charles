package com.fdmgroup.com.SpringSoloProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Record;

import com.fdmgroup.com.SpringSoloProject.service.RecordService;

@SpringBootTest
class RecordServiceTest {

	private RecordService recordService;

	@MockBean
	private RecordRepository recordRepo;

	@Mock
	private Record record;

	@BeforeEach
	public void setup() {
		record = new Record();
		recordService = new RecordService(recordRepo);
		
	}

	@Test
	void test_record_isFoundByID() {
		// Arrange
		when(recordRepo.findById(record.getRecordId())).thenReturn(Optional.of(record));

		// Action
		Record foundRecord = recordService.findById(record.getRecordId());

		// Assert
		assertEquals(record.getRecordId(), foundRecord.getRecordId());
		verify(recordRepo, times(1)).findById(record.getRecordId());
	}

	@Test
	void test_record_foundByMemberId() {
		// Arrange

		// Action
		Long MemberId = 1L;
		recordService.findByMemberId(MemberId);

		// Assert
		verify(recordRepo, times(1)).findByMemberId(MemberId);
	}

	@Test
	void test_record_foundAll() {
		// Arrange

		// Action
		recordService.findAll();

		// Assert
		verify(recordRepo, times(1)).findAll();
	}

	@Test
	void test_record_isSaved() {
		// Arrange

		// Action
		recordService.save(record);

		// Assert
		verify(recordRepo, times(1)).save(record);

	}

}
