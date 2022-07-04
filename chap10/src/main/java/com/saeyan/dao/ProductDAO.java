package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ProductVO;

import util.DBManager;

public class ProductDAO { //상품 table인 product에 연동하기 위한 Class(CRUD)형식 Create , Read , Update , Delete 4가지 작업
	
	private ProductDAO() {
	}
	
	private static ProductDAO instance = new ProductDAO(); // 
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// c Read u d
	public List<ProductVO> selectAllProducts() {
		//최근 등록한 상품 먼저 출력하기
		String sql = "select * from product order by code desc"; // select문을 sql에 저장
		List<ProductVO> list = new ArrayList<ProductVO>(); // 상품 정보 한 개 이상을 저장하기 위해 ArrayList 클래스로 객체 생성
		Connection conn = null; // DB 연결
		PreparedStatement pstmt = null; // 쿼리 실행
		ResultSet rs = null; // 결과 출력
		try {
			conn = DBManager.getConnection();  // Connection 객체를 얻기위해서 호출
			pstmt = conn.prepareStatement(sql); // 쿼리문을 실행하기 위한 객체가 필요해서 conn으로부터 객체를 얻어오고 sql 변수를 전달
			rs = pstmt.executeQuery(); // 쿼리문을 실행하고 결과를 ResultSet 객체에 넣어둠
			while (rs.next()) { // 이동은 행(로우) 단위로 
				ProductVO pVo = new ProductVO(); // ProductVO 객체 생성
				pVo.setCode(rs.getInt("code"));  // code 컬럼값을 얻어와 ProductVO 객체의 code 필드에 저장하기 위해서 setCode 함수사용
				pVo.setName(rs.getString("name"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setPictureUrl(rs.getString("pictureUrl"));
				pVo.setDescription(rs.getString("description"));
				list.add(pVo);
			}// while문 끝
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	} // selectAllProducts() {
	// ProductDAO {

//...중복된 내용이므로 생략
// Create r u d
	public void insertProduct(ProductVO pVo) {
		String sql = "insert into product values(product_seq.nextval, ?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.executeUpdate(); // 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


//... 중복된 내용이므로 생략
	// c Read u d
	public ProductVO selectProductByCode(String code) {
		String sql = "select * from product where code=?";
		ProductVO pVo = null;
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					pVo = new ProductVO();
					pVo.setCode(rs.getInt("code"));
					pVo.setName(rs.getString("name"));
					pVo.setPrice(rs.getInt("price"));
					pVo.setPictureUrl(rs.getString("pictureUrl"));
					pVo.setDescription(rs.getString("description"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt , rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pVo;
  }


// ... 중복된 내용이므로 생략
// c r Update d
	public void updateProduct(ProductVO pVo) {
		String sql = "update product set name=?, price=?, pictureurl=?, description=? where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getName());
			pstmt.setInt(2, pVo.getPrice());
			pstmt.setString(3, pVo.getPictureUrl());
			pstmt.setString(4, pVo.getDescription());
			pstmt.setInt(5, pVo.getCode());
			pstmt.executeUpdate(); // 쿼리문 실행한다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}


//... 중복된 내용이므로 생략
 // c r u Delete
	public void deleteProduct(String code) {
		String sql = "delete product where code=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate(); // 쿼리문 실행\
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
	}
}