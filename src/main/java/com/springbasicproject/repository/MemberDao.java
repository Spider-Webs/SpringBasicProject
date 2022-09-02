package com.springbasicproject.repository;

import com.springbasicproject.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    public void insert(Member newMember) {
    }

    public Member selectByEmail(String email) {

        return new Member();
    }
}
