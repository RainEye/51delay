# 51单片机延时计算,并产生延时代码
## 功能
本程序主要用于产生51单片机的延时方法用于辅助c51的开发
## 原理
通过根据晶振频率得出每次循环的时间然后通过多次循环来得到延迟函数(注:循环的方式不同,产生的汇编指令可能不一样,导致一次循环的时间不同)
