package pollResidencial;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PollDAO dao = new PollDAO();
		PollVO vo = new PollVO();
//		PollVO vo = new PollVO(1L, "���", 2);
		
		String ans = ""; 
		int op = 0;
		
		System.out.println("�ɼ��� ����:");		
		op = sc.nextInt();
		if(op == 1) {
			System.out.println("��ǥ�ϼ���");
			System.out.println("�����Է�: ");
			ans = sc.nextLine();
			dao.insertPoll(vo);
		}
		if(op == 2) {
			System.out.println("��ǥ ���");
			System.out.printf("%s : %n", vo.getName(), vo.getVotes());
		}
		else {
			System.out.println("����� ���ڸ� �Է�");
		}
		
		System.out.println(dao.insertPoll(vo));
		
		List<PollVO> ret = dao.selectAll();
		for (PollVO tmp : ret) {
			System.out.println(tmp);
		}
		
		sc.close();
	}
}
