package Service.feedback;

import Service.feedback.FeedBack;

import java.util.HashMap;
import java.util.List;

public interface FeedBackDao {



    public FeedBack getFeedBackById(HashMap map);




    public List<FeedBack> getFeedBackAll();




    /**
     * 新增通知
     *
     * @param feedBack
     */
    public void insertFeedBack(FeedBack feedBack);

    /**
     * 更新通知信息
     *
     * @param feedBack
     */
    public void updateFeedBack(FeedBack feedBack);

    /**
     * 根据id删除通知信息   //根据什么参数来删除通知?
     *
   //  * @param releaseDate
   //  * @param publisher
     */
    public void deleteFeedBack (HashMap map);



}


