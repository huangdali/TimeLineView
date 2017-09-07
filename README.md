# TimeLineView


> 出于效率考虑已经重写，此项目已经迁移至：https://github.com/huangdali/TimeRuler



自定义时间刻度，带时间轴中选择时间

![](https://github.com/huangdali/TimeLineView/blob/master/image.png)

## 导入
app.build中使用

```java
    compile 'com.jwkj:TimeLineView:v1.0.2'
```

## 混淆配置
```java
#timelineview
-keep class com.hdl.timelineview.**{*;}
-dontwarn com.hdl.timelineview.**
```


## 版本记录

v1.0.2 ([2017.08.23]())

- 【优化】修改包名

v1.0.1 ([2017.08.23]())

- 【新增】完成基本功能