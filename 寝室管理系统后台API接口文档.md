# 寝室管理系统后台API接口文档（管理员端）

## 1.1 登录

### 1.1.1. 登录验证接口

- 请求路径：DoLogin (http://47.103.66.24:8080/stuManager/DoLogin)
- 请求方法：post
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| uname   | 用户名   | 不能为空 |
| pwd     | 密码     | 不能为空 |
|identity | 身份     | 1为学生,2为寝室管理员,后面加也行|

- 响应参数

| 参数名   | 参数说明    | 备注            |
| -------- | ----------- | --------------- |
| id       | 用户 ID     |                 |
| rid      | 用户角色 ID |                 |
| username | 用户名      |                 |
| mobile   | 手机号      |                 |
| email    | 邮箱        |                 |

| cookie    | 令牌        | 身份令牌 |
| loginstate   | 标志        | 表示是寝室还是学生 | 
上面这两个有就行，其他不变

- 响应数据//你可以修改

```json
{
    "data": {
        //
    },
    "header": {
        "loginstate":1,
        "cookie":""
    },
    "meta": {
        "msg": "登录成功",
        "status": 200
    }
}
```
## 1.2 个人信息

- 请求路径：
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 备注                  |
| ------ | -------- | --------------------- |
| cookie    | 令牌        | 身份令牌 |

- 响应参数

| 参数名     | 参数说明 | 备注 |
| -------   | ------- | ---- |
| name      | 姓名     |      |
| studentId | 学号     |      |
| class     | 班级     |      |
| building  | 寝室楼   |      |
| number    | 寝室号   |      |
| homeAdr   | 家庭地址 |      |
| email     | 邮箱     |      |
| phone     | 联系方式 |      |


- 响应数据//你可以修改

```json
{
    "data": {
        "name": ,
        "studentId": "",
        "class": 0,
        "building": "14",
        "number": "607",
        "homeAdr": "shenzhen",
        "email": "new@new.com",
        "phone": "110"
    },
    "meta": {
        "msg": "查询成功",
        "status": 200
    }
}
```
## 1.2 寝室信息

- 请求路径：
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 备注                  |
| ------ | -------- | --------------------- |
| cookie    | 令牌        | 身份令牌 |

- 响应参数

| 参数名     | 参数说明 | 备注 |
| -------   | ------- | ---- |
| name      | 姓名     |      |
| studentId | 学号     |      |
| college   | 学院     |      |
| class     | 班级     |      |
| date      | 日期  |      |
| building  | 寝室楼  |      |
| number    | 寝室号   |      |
| usewater  | 用水量 |      |
| useelectri| 用电量     |      |
| score     | 寝室分数 |      |


- 响应数据//你可以修改,只是例子

```json
{
    "data": {
        studentInfo:[
            {
                "name":"李嘉锴",
                "studentId": "18190124",
                "college": "计算机学院",
                "class": "18052315"
            },
            {
                "name":"赵柯杰",
                "studentId": "",
                "college": "计算机学院",
                "class": "18052315"
            },
            {
                "name":"赵高远",
                "studentId": "",
                "college": "计算机学院",
                "class": "18052315"
            },..
        ],
        info:[
            {
                "date":"",
                "building":"",
                "number":"",
                "usewater":"",
                "useelectri":"",
                "score":""
            }
        ]


    },
    "meta": {
        "msg": "查询成功",
        "status": 200
    }
}
```
INSERT INTO StuAccount (
        ID,
        password,
        Email
        )
        VALUES
        (
        18051511,
        '123456',
        '872367373@qq.com'
        );




   INSERT INTO StuInfo (
        ID,
        name,
        Email,
        classId,
        mobilePhone,
        buildingId,
        roomId,
        homeAddress,
        cardBalance

        )
        VALUES
        (
        18051511,
        '张五',
        '87227373@qq.com',
        '18013',
        '343343465',
        '1',
        '207',
        '中国浙江',
        '111'
        );
        
        




        INSERT INTO StuRoom (
        ID,
        BuildingId,
        healthScore,
        electricityBalance,
        waterBalance
        )
        VALUES
        (
        502,
        "5",
        96,
        65,
        80
        );