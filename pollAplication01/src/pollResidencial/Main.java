package pollResidencial;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PollDAO dao = new PollDAO();
		PollVO vo = new PollVO();
//		PollVO vo = new PollVO(1L, "���", 2);
		
		boolean con = true;
		String ans = ""; 
		int op = 0;
		
		while(con == true) {
			System.out.println("-----------------");
			System.out.println("1=��ǥ 2=��� 3=����");
			System.out.print("�ɼ� ����: ");
			
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
			case 1:
				System.out.println("��ǥ�ϼ���");
				System.out.print("�����Է�: ");
				ans = sc.nextLine();
				System.out.printf("\n%s�� ��ǥ�ϼ̽��ϴ�\n", ans);
				break;
			
			case 2: 
				System.out.println("��ǥ ���");
				System.out.printf("%s : %n", vo.getName(), vo.getVotes());
				break;
			
			case 3:
				System.out.println("\n *** ok ���� *** ");
				con = false;
				sc.close();
				break;
				
			default:
				System.out.println("\n����� ���ڸ� �Է�");
				continue;
			}
		
//		System.out.println(dao.insertPoll(vo));
		
//		List<PollVO> ret = dao.selectAll();
//		for (PollVO tmp : ret) {
//			System.out.println(tmp);
//		}
		}
	}
}
