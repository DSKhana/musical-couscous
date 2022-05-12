package pollResidencial;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PollDAO dao = new PollDAO();
		PollVO vo = new PollVO();
		
		boolean con = true;
		String ans = "";
		int selec = 0;
		int op = 0;
		
		while(con == true) {
			System.out.println("-----------------");
			System.out.println("[�ɼ�] 1:��ǥ 2:��� 3:����");
			System.out.print("�ɼ� ����: ");
			
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
			case 1:
				System.out.println("��ǥ ����");
				System.out.println("1:��Ű�� 2:������ 3:����� 4:�����Է�");
				System.out.print("��ȣ�Է�: ");
				selec = Integer.parseInt(sc.nextLine());
				if(selec < 4) {
					vo = new PollVO(selec, ans, 0);
					dao.UpdatePoll(vo);
					System.out.printf("\n%d�� ��ǥ�ϼ̽��ϴ�\n", selec);
					
				}
				if(selec == 4) {
					System.out.println("Ű��� ��������:");
					ans = sc.nextLine();
					vo = new PollVO(1, ans, 0);
					System.out.println(dao.insertPoll(vo));
					System.out.printf("\n%s�� ��ǥ�ϼ̽��ϴ�\n", ans);
				}				
				break;
			
			case 2: 
				System.out.println("��ǥ ���");
				List<PollVO> ret = dao.selectAll();
				for (PollVO tmp : ret) {
					System.out.println(tmp);
				}
				break;
			
			case 3:
				System.out.println("\n *** ���� ���� *** ");
				con = false;
				sc.close();
				break;
				
			default:
				System.out.println("\n����� ���ڸ� �Է�");
				continue;
			}		
		}		
	}
}
