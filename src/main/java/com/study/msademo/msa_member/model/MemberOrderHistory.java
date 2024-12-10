//package com.study.msademo.msa_member.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
///**
// * =======================================================
// * @class		: MemberOrderHistory
// * @author		: 이혜경
// * @date		: 2024-12-09
// * @desc		: MemberOrderHistory domain
// * @history		:
// * -------------------------------------------------------
// * NO	DATE       	AUTHOR	NOTE
// * -------------------------------------------------------
// * 1.	2024-12-09 이혜경
// */
//@Entity
//@Data
//public class MemberOrderHistory {
//    @Id @Column(name = "order_history_id")
//    @GeneratedValue
//    private Long orderHistoryId;
//
//    @Column(name = "order_date")
//    private LocalDateTime orderDate;
//
//    @Column(name = "order_qty")
//    private int orderQty;
//
//    @Column(name = "order_amount")
//    private int orderAmount;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    /* 기본 생성자: JPA에서 리플렉션을 통해 객체 생성에 사용되는 기본 생성자_외부에서의 객체 생성을 방지함 */
//    protected MemberOrderHistory() {}
//
//}
