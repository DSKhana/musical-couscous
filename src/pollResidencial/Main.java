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
			System.out.println("[옵션] 1:투표 2:결과 3:종료");
			System.out.print("옵션 선택: ");
			
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
			case 1:
				System.out.println("투표 시작");
				System.out.println("1:안키움 2:강아지 3:고양이 4:직접입력");
				System.out.print("번호입력: ");
				selec = Integer.parseInt(sc.nextLine());
				if(selec < 4) {
					vo = new PollVO(selec, ans, 0);
					dao.UpdatePoll(vo);
					System.out.printf("\n%d에 투표하셨습니다\n", selec);
					
				}
				if(selec == 4) {
					System.out.println("키우는 동물종류:");
					ans = sc.nextLine();
					vo = new PollVO(1, ans, 0);
					System.out.println(dao.insertPoll(vo));
					System.out.printf("\n%s에 투표하셨습니다\n", ans);
				}				
				break;
			
			case 2: 
				System.out.println("투표 결과");
				List<PollVO> ret = dao.selectAll();
				for (PollVO tmp : ret) {
					System.out.println(tmp);
				}
				break;
			
			case 3:
				System.out.println("\n *** 설문 종료 *** ");
				con = false;
				sc.close();
				break;
				
			default:
				System.out.println("\n제대로 숫자를 입력");
				continue;
			}		
		}		
	}
}
