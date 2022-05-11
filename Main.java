package pollResidencial;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PollDAO dao = new PollDAO();
		PollVO vo = new PollVO();
//		PollVO vo = new PollVO(1L, "상빈", 2);
		
		String ans = ""; 
		int op = 0;
		
		System.out.println("옵션을 선택:");		
		op = sc.nextInt();
		if(op == 1) {
			System.out.println("투표하세요");
			System.out.println("지역입력: ");
			ans = sc.nextLine();
			dao.insertPoll(vo);
		}
		if(op == 2) {
			System.out.println("투표 결과");
			System.out.printf("%s : %n", vo.getName(), vo.getVotes());
		}
		else {
			System.out.println("제대로 숫자를 입력");
		}
		
		System.out.println(dao.insertPoll(vo));
		
		List<PollVO> ret = dao.selectAll();
		for (PollVO tmp : ret) {
			System.out.println(tmp);
		}
		
		sc.close();
	}
}
