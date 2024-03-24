package com.example.member.domain.model;

import com.example.member.domain.model.vo.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;
    @Embedded
    private IDName idName;
    @Embedded
    private Password password;
    @Embedded
    private Email email;
    @ElementCollection
    private List<Authority> authorityList = new ArrayList<Authority>();
    @Embedded
    private Point point;

    public static Member registerMember(IDName idName, Password pwd, Email email) {
        Member member = new Member();
        member.setIdName(idName);
        member.setPassword(pwd);
        member.setEmail(email);
        member.setPoint(new Point(0L));
        member.addAuthority(new Authority(UserRole.USER));
        return member;
    }

    private void addAuthority(Authority authority) {
        this.authorityList.add(authority);
    }

    public void savePoint(Long point) {
        this.point.addPoint(point);
    }

    public void usePoint(long point) throws Exception {
        this.point.removePoint(point);
    }

    public Member login(IDName idName, Password password) {
        return this;
    }

    public void logout(IDName idName) {

    }
}
