package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

    @Test
    public void Rq__getPath() {
        Rq rq = new Rq("삭제?id=1");

        String path = rq.getPath();

        assertEquals("삭제", path);
    }

    @Test
    public void Rq__getIntParam() {
        Rq rq = new Rq("삭제?id=1");

        int id = rq.getIntParam("id", 0);

        assertEquals(1, id);
    }

    @Test
    public void Rq__getIntParam__2() {
        Rq rq = new Rq("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);
    }

    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 문자열을_스캐너의_입력으로_설정() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent(); // 문자열 안의 모든 라인에 strip를 적용하여 앞 뒤 공백을 제거
        // trim : 앞뒤 공백을 제거한 문자열의 복사본을 리턴
        // strip() 메소드는 trim() 보다 더 많은 종류의 공백을 제거


        InputStream in = new ByteArrayInputStream(input.getBytes());
        // InputStream : 바이트 기반 입력 스트림의 최상위 추상클래스
        // + 키보드에서 입력한 데이터를 읽을 때 등 데이터를 읽을 때 사용
        // ByteArrayInputStream : 다른곳에 입출력하기 전에 데이터를 임시로 바이트 배열에 담아서 변환등의 작업을 하는데 사용

        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();
        // nextLine() : Enter를 치기 전까지 쓴 문자열 모두 반환
        // + 한줄 단위로 입력을 받기 때문에 개행문자(엔터)도 포함
        // next() : 공백(space) 전까지 입력받은 문자열을 반환
        // + 개행문자(엔터)를 무시하고 입력

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }

    @Test
    public void 표준출력을_리다이렉션하여_결과를_문자열로_받기() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        // 그 동안 System.out.println 으로 모아놨던 문장들을 받아옴
        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }
}
