# TestAboutActivity
+ activity生命周期，转屏数据保存
- activity启动模式，4种
    - standard 标准
    - singleTop 在任务栈最顶端的不会重新创建
    - singleTask 存在的activity不会重新创建，会直接到任务栈最顶端，原本在其上面的会全部出栈
    - singleInstance 单实例模式，该方式创建的activity只能单独存在一个栈里面，后续也不会重复创建新的
+ 使用intent.addFlags()方法设置启动模式优先级更高。
+ intent相关使用
+ 都是自己学习的记录，基本没有参考价值


