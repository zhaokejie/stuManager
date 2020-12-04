package Dao;

import Service.building.Room;
import Service.notice.Notice;
import Service.notice.NoticeDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class NoticeDaoImpl  implements NoticeDao{

    public SqlSession sqlSession;

    public NoticeDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }




    @Override
    public List<Notice> getNoticeAll() {
        return this.sqlSession.selectList("NoticeDao.getNoticeAll");
    }

    @Override
    public void insertNotice(Notice notice) { this.sqlSession.insert("NoticeDao.insertNotice",notice); }

    @Override
    public void updateNotice(Notice notice) { this.sqlSession.update("NoticeDao.updateNotice",notice); }

    @Override
    public void deleteNotice(String releaseDate) {
        this.sqlSession.delete("NoticeDao.deleteNotice",releaseDate);
    }

    @Override
    public Notice getNoticeById(HashMap map) {
        return this.sqlSession.selectOne("NoticeDao.getNoticeById",map);
    }

}


