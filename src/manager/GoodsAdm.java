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
			System.out.println("1.��ǰ���  2.��ǰ����  3.��ǰ����  4.��ü���� 5.��ǰ�˻� 6.��ǰ��� ");
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
		System.out.println("����� ��ǰ�� ���̵� �Է��ϼ���");
		String id = in.nextLine();
		System.out.println("����� ��ǰ�� ������ �Է����ּ���");
		int rnum = in.nextInt();
		in.nextLine();
		for(int i=0; i<goods.size(); i++) {
			if(goods.get(i).getgID().equals(id)) {
				goods.get(i).setgNUM(goods.get(i).getgNUM()-rnum);
				String rmemo ="���:" + nowTime + " " + rnum + "��";
				goods.get(i).setgMEMO(rmemo);
				break;
			}
		}
	}		


	private void search() {
		System.out.println("�˻��� ��ǰ���� �Է��ϼ���");
		String name = in.nextLine();
		for(int i=0; i<goods.size(); i++) {
			if(goods.get(i).getgNAME().contains(name)) {
				goods.get(i).prt();
			}
		}
	}

	private void listAll() {
		for(int i=0; i<goods.size(); i++) {
			System.out.println("��ǰ��ȣ:" + i);
			goods.get(i).prt();
		}
	}

	private void mod() {
		System.out.println("������ ��ǰ�� ��ȣ�� �Է����ּ���");
		int selnum= in.nextInt();
		in.nextLine();
		System.out.println("��ǰ�� �̸��� �������ּ���");
		String name = in.nextLine();
		goods.get(selnum).setgNAME(name);
		System.out.println("��ǰ�� ������ �������ּ���");
		int num = in.nextInt();
		goods.get(selnum).setgNUM(num);
	}

	private void del() {
		System.out.println("������ ��ȣ�� �Է����ּ���");
		int num =in.nextInt();
		in.nextLine();
		goods.remove(num);

	}

	private void insert() {
		System.out.println("���̵� �Է����ּ���");
		String id = in.nextLine();
		if(idchk(id)==false) {
			System.out.println("��ǰ���� �Է����ּ���");
			String name = in.nextLine();
			System.out.println("��ǰ�� ������ �Է����ּ���");
			int num = in.nextInt();
			in.nextLine();
			String memo ="�԰�" + nowTime+ " "+ num + "��";
		
		
			GoodsInfo info = new GoodsInfo();
			info.setgID(id);
			info.setgNAME(name);
			info.setgNUM(num);
			info.setgMEMO(memo);

			goods.add(info);
			System.out.println(memo);
		} else {
			System.out.println("�ߺ��� ���̵��Դϴ�");
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
	