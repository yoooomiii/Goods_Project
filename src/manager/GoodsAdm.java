package manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import vo.GoodsInfo;

public class GoodsAdm {
	Scanner in = new Scanner(System.in);
	ArrayList<GoodsInfo> goods = new ArrayList<> ();
	LocalDate now = LocalDate.now();
	 String nowTime = now.toString();
	
	
	public GoodsAdm() {
		while(true) {
			System.out.println("1.물품등록  2.물품삭제  3.물품수정  4.전체보기 5.물품검색 6.물품출고 ");
			int selnum = in.nextInt();
			in.nextLine();
			if(selnum==1) {
				insert();
			} else if(selnum==2) {
				del();
			} else if(selnum==3) {
				mod();
			} else if(selnum==4) {
				listAll();
			} else if(selnum==5) {
				search();
			} else if(selnum==6) {
				release();
			} else {
				break;
			}
		}
	}

	private void release() {
		listAll();
		System.out.println("출고할 물품의 아이디를 입력하세요");
		String id = in.nextLine();
		System.out.println("출고할 물품의 수량을 입력해주세요");
		int rnum = in.nextInt();
		in.nextLine();
		for(int i=0; i<goods.size(); i++) {
			if(goods.get(i).getgID().equals(id)) {
				goods.get(i).setgNUM(goods.get(i).getgNUM()-rnum);
				String rmemo ="출고:" + nowTime + " " + rnum + "개";
				goods.get(i).setgMEMO(rmemo);
				break;
			}
		}
	}		


	private void search() {
		System.out.println("검색할 물품명을 입력하세요");
		String name = in.nextLine();
		for(int i=0; i<goods.size(); i++) {
			if(goods.get(i).getgNAME().contains(name)) {
				goods.get(i).prt();
			}
		}
	}

	private void listAll() {
		for(int i=0; i<goods.size(); i++) {
			System.out.println("물품번호:" + i);
			goods.get(i).prt();
		}
	}

	private void mod() {
		System.out.println("수정할 물품의 번호를 입력해주세요");
		int selnum= in.nextInt();
		in.nextLine();
		System.out.println("물품의 이름을 수정해주세요");
		String name = in.nextLine();
		goods.get(selnum).setgNAME(name);
		System.out.println("물품의 수량을 수정해주세요");
		int num = in.nextInt();
		goods.get(selnum).setgNUM(num);
	}

	private void del() {
		System.out.println("삭제할 번호를 입력해주세요");
		int num =in.nextInt();
		in.nextLine();
		goods.remove(num);

	}

	private void insert() {
		System.out.println("아이디를 입력해주세요");
		String id = in.nextLine();
		if(idchk(id)==false) {
			System.out.println("물품명을 입력해주세요");
			String name = in.nextLine();
			System.out.println("물품의 수량을 입력해주세요");
			int num = in.nextInt();
			in.nextLine();
			String memo ="입고" + nowTime+ " "+ num + "개";
		
		
			GoodsInfo info = new GoodsInfo();
			info.setgID(id);
			info.setgNAME(name);
			info.setgNUM(num);
			info.setgMEMO(memo);

			goods.add(info);
			System.out.println(memo);
		} else {
			System.out.println("중복된 아이디입니다");
		}
	}

	private boolean idchk(String id) {
		for(int i=0; i<goods.size(); i++) {
			if(goods.get(i).getgID().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
	