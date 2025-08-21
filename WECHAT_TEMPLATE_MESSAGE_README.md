# 微信公众号模板消息推送功能

## 功能概述

本功能实现了在课程开始前一天自动发送微信公众号模板消息提醒的功能，帮助用户及时了解课程安排。

## 主要特性

- 自动定时发送课程提醒
- 支持手动触发发送
- 批量发送给所有报名用户
- 可配置的提醒时间
- 完整的日志记录

## 配置说明

### 1. 微信公众号配置

在 `src/main/resources/wechat.yml` 文件中配置微信公众号信息：

```yaml
wx:
  mp:
    appid: ${WX_MP_APPID:your_mp_appid}        # 微信公众号AppID
    secret: ${WX_MP_SECRET:your_mp_secret}     # 微信公众号AppSecret
    token: ${WX_MP_TOKEN:your_mp_token}        # 微信公众号Token
    aesKey: ${WX_MP_AES_KEY:your_mp_aes_key}  # 微信公众号AESKey
    template:
      course-reminder: ${WX_MP_TEMPLATE_COURSE_REMINDER:your_template_id}  # 课程提醒模板ID
```

### 2. 环境变量配置

在系统环境变量中设置以下值：

```bash
export WX_MP_APPID=your_actual_mp_appid
export WX_MP_SECRET=your_actual_mp_secret
export WX_MP_TOKEN=your_actual_mp_token
export WX_MP_AES_KEY=your_actual_mp_aes_key
export WX_MP_TEMPLATE_COURSE_REMINDER=your_actual_template_id
```

## 模板消息格式

课程提醒模板消息包含以下字段：

- **first**: 您好，明天有课程安排，请及时参加！
- **keyword1**: 课程标题
- **keyword2**: 课程时间
- **keyword3**: 课程地点
- **keyword4**: 课程简介（前50个字符）
- **remark**: 请提前做好准备，准时参加！

## 定时任务配置

### 自动提醒时间

- **每天早上8点**: 发送明天的课程提醒
- **每天晚上8点**: 发送后天的课程提醒（可选，用于测试）

### 自定义定时

可以在 `ScheduleConfig` 类中修改 `@Scheduled` 注解的cron表达式来调整定时任务执行时间。

## API接口

### 1. 手动发送明天的课程提醒

```
POST /api/leda/course-reminder/send-tomorrow
```

### 2. 手动发送指定日期的课程提醒

```
POST /api/leda/course-reminder/send-by-date?date=2024-12-20
```

### 3. 获取需要发送提醒的活动列表

```
GET /api/leda/course-reminder/activities?date=2024-12-20
```

## 使用步骤

### 1. 配置微信公众号

1. 在微信公众平台获取AppID、AppSecret等信息
2. 配置服务器地址和Token
3. 创建模板消息，获取模板ID

### 2. 配置环境变量

设置所有必要的环境变量

### 3. 启动应用

应用启动后会自动开始执行定时任务

### 4. 测试功能

使用API接口手动触发发送，验证功能是否正常

## 注意事项

1. **用户绑定**: 只有绑定了微信公众号的用户才能收到模板消息
2. **模板ID**: 确保模板ID配置正确，否则无法发送消息
3. **权限**: 微信公众号需要有发送模板消息的权限
4. **频率限制**: 注意微信对模板消息发送频率的限制
5. **错误处理**: 系统会记录所有发送失败的情况，便于排查问题

## 扩展功能

### 1. 添加更多提醒类型

可以在 `WeChatTemplateMessageService` 中添加其他类型的模板消息发送方法

### 2. 自定义提醒时间

可以修改定时任务的cron表达式，实现更灵活的提醒时间

### 3. 添加提醒记录

可以创建数据库表记录所有发送的提醒消息，便于统计和分析

## 故障排查

### 1. 模板消息发送失败

- 检查微信公众号配置是否正确
- 确认模板ID是否存在
- 查看用户是否已绑定微信公众号

### 2. 定时任务不执行

- 检查 `@EnableScheduling` 注解是否生效
- 查看定时任务的cron表达式是否正确
- 检查应用日志中是否有相关错误信息

### 3. 用户收不到消息

- 确认用户是否已关注微信公众号
- 检查用户是否有openid
- 验证模板消息格式是否正确

## 技术支持

如有问题，请查看应用日志或联系开发团队。 