package kr.co.springbootweeklymission.member.domain.repository;

import kr.co.springbootweeklymission.infrastructure.error.exception.FileIOException;
import kr.co.springbootweeklymission.infrastructure.error.model.ResponseStatus;
import kr.co.springbootweeklymission.infrastructure.util.FileConverter;
import kr.co.springbootweeklymission.member.domain.entity.Member;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InFileMemberRepository implements MemberRepository {
    private static final File MEMBER_FILE = new File("src/main/resources/files/member_file.csv");

    @Override
    public List<Member> findMembersByBlack() {
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE));
            final List<Member> members = getMembersByBlack(reader);
            reader.close();

            return members;
        } catch (IOException e) {
            throw new FileIOException(ResponseStatus.FAIL_NOT_FOUND_BLACK_MEMBER);
        }
    }

    private List<Member> getMembersByBlack(BufferedReader reader) throws IOException {
        final List<Member> members = new ArrayList<>();
        String info = reader.readLine();

        while (info != null) {
            final Member member = FileConverter.toMember(info);

            if (member.isBlackMember()) {
                members.add(member);
            }

            info = reader.readLine();
        }

        return members;
    }
}
