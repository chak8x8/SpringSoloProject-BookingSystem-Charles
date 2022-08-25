package com.fdmgroup.com.SpringSoloProject;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.com.SpringSoloProject.dal.MemberRepository;
import com.fdmgroup.com.SpringSoloProject.dal.RecordRepository;
import com.fdmgroup.com.SpringSoloProject.model.Member;
import com.fdmgroup.com.SpringSoloProject.model.Record;

/**
 * 
 * @author chak8x8
 * This class is to allow batch loading of data that is identified by a set of unique keys. 
 * It will pre-load some data to MySQL.
 */
@Service
public class Dataloader implements ApplicationRunner{
	private MemberRepository memberRepo;
//	private RoomRepository roomRepo;
	private RecordRepository recordRepo;
	
	
	@Autowired
	public Dataloader(MemberRepository memberRepo, RecordRepository recordRepo) {
		super();
		this.memberRepo = memberRepo;
		this.recordRepo = recordRepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("The Room Repository is running");
//		Room room1 = new Room(0, 0, 100);
//		Room room2 = new Room(0, 1, 150);
//		Room room3 = new Room(0, 2, 300);
//		this.roomRepo.saveAll(Arrays.asList(room1, room2, room3));
//		System.out.println("The Room data is saved");
		System.out.println("The Member Repository is running");
		Member member1 = new Member("Peter", "Smith", "peter@fdm.com", new BCryptPasswordEncoder().encode("123456"), "1234-5678-9001-1234");
		Member member2 = new Member("Jerry", "Drink", "jerry@fdm.com", new BCryptPasswordEncoder().encode("246810"), "1245-2345-3456-1234");
		this.memberRepo.saveAll(Arrays.asList(member1, member2));
		System.out.println("The Member data is saved");
		System.out.println("The Record Repository is running");
//		List<Room> roomList = roomRepo.findAll();
		List<Member> memberList = memberRepo.findAll();
		Date date1 = new Date();
		Date date2 = new Date();
		Record record1 = new Record(memberList.get(0), date1, date2, false);
		Record record2 = new Record(memberList.get(1), date1, date2, false);
		this.recordRepo.saveAll(Arrays.asList(record1, record2));
		System.out.println("The Record data is saved");

	}


}