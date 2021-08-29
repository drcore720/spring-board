package hello.springboard.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(nullable = false, length=200)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(name = "writedate", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime writedate;
    @Column(name = "editdate", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime editdate;
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer readcount;
    @Column(name="writer")
    @ColumnDefault("0")
    private Long memberSeq;
    @Column(name="delflag")
    private Boolean delflag;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getWritedate() {
        return writedate;
    }

    public void setWritedate(LocalDateTime writedate) {
        this.writedate = writedate;
    }

    public LocalDateTime getEditdate() {
        return editdate;
    }

    public void setEditdate(LocalDateTime editdate) {
        this.editdate = editdate;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Long getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(Long memberSeq) {
        this.memberSeq = memberSeq;
    }

    public Boolean getDelflag() {
        return delflag;
    }

    public void setDelflag(Boolean delflag) {
        this.delflag = delflag;
    }
}
