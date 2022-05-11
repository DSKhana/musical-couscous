package pollResidencial;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PollDAO dao = new PollDAO();
		PollVO vo = new PollVO();
//		PollVO vo = new PollVO(1L, "상빈", 2);
		
		boolean con = true;
		String ans = ""; 
		int op = 0;
		
		while(con == true) {
			System.out.println("-----------------");
			System.out.println("1=투표 2=결과 3=종료");
			System.out.print("옵션 선택: ");
			
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
			case 1:
				System.out.println("투표하세요");
				System.out.print("지역입력: ");
				ans = sc.nextLine();
				System.out.printf("\n%s에 투표하셨습니다\n", ans);
				break;
			
			case 2: 
				System.out.println("투표 결과");
				System.out.printf("%s : %n", vo.getName(), vo.getVotes());
				break;
			
			case 3:
				System.out.println("\n *** ok 종료 *** ");
				con = false;
				sc.close();
				break;
				
			default:
				System.out.println("\n제대로 숫자를 입력");
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
