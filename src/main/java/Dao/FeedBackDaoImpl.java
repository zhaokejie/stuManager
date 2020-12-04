package Dao;

import Service.feedback.FeedBack;
import Service.feedback.FeedBackDao;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class FeedBackDaoImpl implements FeedBackDao {

    public SqlSession sqlSession;

    public FeedBackDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public FeedBack getFeedBackById(HashMap map) {
        return this.sqlSession.selectOne("FeedBackDao.getFeedBackById", map);
    }


    @Override
    public List<FeedBack> getFeedBackAll() {
        return this.sqlSession.selectList("FeedBackDao.getFeedBackAll");
    }

    @Override
    public void insertFeedBack(FeedBack notice) {
        this.sqlSession.insert("NoticeDao.insertNotice", notice);
    }

    @Override
    public void updateFeedBack(FeedBack notice) {
        this.sqlSession.update("NoticeDao.updateNotice", notice);
    }

    @Override
    public void deleteFeedBack(HashMap map) {
        this.sqlSession.delete("FeedBackDao.deleteFeedBack", map);
    }

}