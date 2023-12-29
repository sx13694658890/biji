有个babel 插件可以帮你移除所有的console.*调用。首先需要使用yarn add --dev babel-plugin-transform-remove-console来安装，然后在项目根目录下编辑（或者是新建）一个名为·.babelrc`的文件，在其中加入：

{
  "env": {
    "production": {
      "plugins": ["transform-remove-console"]
    }
  }
}


virtualizedList  虚拟列表


yarn add react-native-fast-image