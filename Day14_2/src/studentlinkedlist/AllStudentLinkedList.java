package studentlinkedlist;

import java.util.Scanner;

public class AllStudentLinkedList {
	static StudentScoreHasA head;
	static StudentScoreHasA cur;
	static StudentScoreHasA newNode;
	static StudentScoreHasA del;

	private int index;

	public int getIndex() {
		return index;
	}

	public static void main(String[] args) {
		/*
		 * 1. 학생정보입력 2. 학생정보수정 3. 학생정보검색 4. 학생전체출력
		 */

		AllStudentLinkedList stu = new AllStudentLinkedList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. 학생정보입력");
			System.out.println("2. 학생정보수정");
			System.out.println("3. 학생정보검색");
			System.out.println("4. 학생전체출력");
			System.out.println("5. 학생정보삭제");
			System.out.println("6.  종료");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				stu.setSorted(stu.setStudent());
				break;
			case 2:
				stu.setSorted(stu.setModify());
				break;
			case 3:
				stu.setSearch();
				break;
			case 4:
				stu.setDisp();
				break;
			case 5:
				stu.setDel();
				break;
			case 6:
				System.exit(0);
				;
				break;
			}

		} while (true);

	}

	private void setDel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("누구의 정보를 삭제할까요?: ");
		String name = sc.next();

		cur = head;
		if (name.equals(head.getName())) {

			del = head;
			head = head.next;
			del.next = null;
			del = null;
			cur = head;
		} else {
			while (cur != null || cur.next != null) {
				if (name.equals(cur.next.getName())) {
					del = cur.next;
					cur.next = del.next;
					del.next = null;
					del = null;
					break;
				}
				cur = cur.next;
			}
		}
	}

	private StudentScoreHasA setModify() {
		Scanner sc = new Scanner(System.in);
		StudentScoreHasA tmp = null;
		System.out.println("누구의 점수를 수정할까요?: ");
		String name = sc.next();

		cur = head;

		if (head == null) {
			System.out.println("등록된 학생이 없습니다.");
			return null;
		} else if (head.next == null && name.equals(head.getName())) {
			System.out.println("찾았습니다. ");
			while (true) {
				System.out.println("1.국어점수수정");
				System.out.println("2.영어점수수정");
				System.out.println("3.수학점수수정");
				System.out.println("4.수정안함");

				int n = sc.nextInt();
				switch (n) {
				case 1:
					System.out.println("국어점수를 입력해주세요: ");
					head.setKor(sc.nextInt());
					break;
				case 2:
					System.out.println("영어점수를 입력해주세요: ");
					head.setEng(sc.nextInt());
					break;
				case 3:
					System.out.println("수학점수를 입력해주세요: ");
					head.setMat(sc.nextInt());
					break;

				}
				if (n == 4)
					break;
			}
			return head;
		} else {

			while (cur.next != null) {
				if (name.equals(cur.next.getName())) {
					System.out.println("찾았습니다. ");

					while (true) {
						System.out.println("1.국어점수수정");
						System.out.println("2.영어점수수정");
						System.out.println("3.수학점수수정");
						System.out.println("4.수정안함");

						int n = sc.nextInt();
						switch (n) {
						case 1:
							System.out.println("국어점수를 입력해주세요: ");
							cur.next.setKor(sc.nextInt());
							break;
						case 2:
							System.out.println("영어점수를 입력해주세요: ");
							cur.next.setEng(sc.nextInt());
							break;
						case 3:
							System.out.println("수학점수를 입력해주세요: ");
							cur.next.setMat(sc.nextInt());
							break;

						}
						if (n == 4)
							break;
					}
					tmp = cur.next;
					cur.next = cur.next.next;
				}
				cur = cur.next;
			}
			return tmp;
		}
	}

	private void setSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 학생의 이름을 검색해주세요: ");
		String name = sc.next();

		cur = head;

		while (cur != null) {
			if (name.equals(cur.getName())) {
				System.out.println("찾았습니다. ");
				System.out.print(cur.getName() + "\t");
				System.out.print(cur.getKor() + "\t");
				System.out.print(cur.getEng() + "\t");
				System.out.print(cur.getMat() + "\t");
				System.out.print(cur.getTotal() + "\t");
				System.out.println(cur.getAvg());
				break;
			}
			cur = cur.next;
		}
	}

	private void setDisp() {

		cur = head;

		while (cur != null) {
			System.out.print(cur.getName() + "\t");
			System.out.print(cur.getKor() + "\t");
			System.out.print(cur.getEng() + "\t");
			System.out.print(cur.getMat() + "\t");
			System.out.print(cur.getTotal() + "\t");
			System.out.println(cur.getAvg());
			cur = cur.next;
		}
	}

	public StudentScoreHasA setStudent() {

		StudentScoreHasA newNode = new StudentScoreHasA(); // 학생객체생성
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요: ");
		newNode.setName(sc.next());
		System.out.print("국어점수를 입력해주세요: ");
		newNode.setKor(sc.nextInt());
		System.out.print("영어점수를 입력해주세요: ");
		newNode.setEng(sc.nextInt());
		System.out.print("수학점수를 입력해주세요: ");
		newNode.setMat(sc.nextInt());
		newNode.getTotal();
		newNode.getAvg();
		return newNode;
	}

	public void setSorted(StudentScoreHasA newNode) {

		if (head == null) {
			newNode.next = head;
			head = cur = newNode;

		} else {

			cur = head;

			if (newNode.getTotal() > head.getTotal()) {
				newNode.next = head;

				cur = head = newNode;

			} else if (head.getTotal() > newNode.getTotal() && head.next == null) {
				head.next = newNode;

			} else {
				while (cur.next != null) {
					if (newNode.getTotal() > cur.next.getTotal()) {
						newNode.next = cur.next;
						cur.next = newNode;
						break;
					} else if (newNode.getTotal() < cur.next.getTotal() && cur.next.next == null) {
						cur.next.next = newNode;
					} else {
						cur = cur.next;
					}

				}

			}
		}

	} // method 마지막
}