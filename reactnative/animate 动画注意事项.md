注意事项
本机驱动程序目前并不足以支持您使用 Animated 执行所有操作。主要限制是您只能为非布局属性设置动画：像 transform 和 opacity 这样的东西可以工作，但 flexbox 和 position 属性不能。使用 Animated.event 时，它只适用于直接事件，而不适用于冒泡事件。这意味着它不能与 PanResponder 一起使用，但可以与 ScrollView#onScroll 之类的东西一起使用。

动画运行时，可以防止 VirtualizedList 组件渲染更多行。如果您需要在用户滚动列表时运行长动画或循环动画，您可以在动画配置中使用 isInteraction: false 来防止此问题。

Animated.event是 Animated 中与输入有关的部分，允许手势或其它事件直接绑定到动态值上。它通过一个结构化的映射语法来完成，使得复杂事件对象中的值可以被正确的解开。第一层是一个数组，允许同时映射多个值，然后数组的每一个元素是一个嵌套的对象。在下面的例子里，你可以发现scrollX被映射到了event.nativeEvent.contentOffset.x(event通常是回调函数的第一个参数)，并且pan.x和pan.y分别映射到gestureState.dx和gestureState.dy（gestureState是传递给PanResponder回调函数的第二个参数）。

所有动画值都可以执行插值（interpolation）操作。插值是指将一定范围的输入值映射到另一组不同的输出值，一般我们使用线性的映射，但是也可以使用 easing 函数。默认情况下，它会将曲线外推到给定范围之外，但您也可以让它限制为输出值。

一个简单的将范围 0-1 转换为范围 0-100 的映射操作是：

```javascript 

value.interpolate({
  inputRange: [0, 1],
  outputRange: [0, 100]
});

```
interpolate()还支持任意的渐变函数，其中有很多已经在Easing类中定义了，包括二次、指数、贝塞尔等曲线以及 step、bounce 等方法。interpolation还支持限制输出区间outputRange。你可以通过设置extrapolate、extrapolateLeft或extrapolateRight属性来限制输出区间。默认值是extend（允许超出），不过你可以使用clamp选项来阻止输出值超过outputRange


牢记
在使用 rotateY、rotateX 等变换样式时，请确保使用了变换样式 perspective。此时，如果没有它，某些动画可能无法在 Android 上呈现。下面是一个例子。

<Animated.View
  style={{
    transform: [
      { scale: this.state.scale },
      { rotateY: this.state.rotateY },
      { perspective: 1000 } // without this line this Animation will not render on Android while working fine on iOS
    ]
  }}
/>