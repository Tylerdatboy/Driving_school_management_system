import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import fenpeijiaolian from '@/views/modules/fenpeijiaolian/list'
    import yuyuelianxi from '@/views/modules/yuyuelianxi/list'
    import xueyuan from '@/views/modules/xueyuan/list'
    import kaoshianpai from '@/views/modules/kaoshianpai/list'
    import jiaxiaojiaolian from '@/views/modules/jiaxiaojiaolian/list'
    import jiaofeixinxi from '@/views/modules/jiaofeixinxi/list'
    import jiaolianpingjia from '@/views/modules/jiaolianpingjia/list'
    import systemintro from '@/views/modules/systemintro/list'
    import xuexijihua from '@/views/modules/xuexijihua/list'
    import cheliangweihu from '@/views/modules/cheliangweihu/list'
    import jiaxiaobaoming from '@/views/modules/jiaxiaobaoming/list'
    import jiaxiaocheliang from '@/views/modules/jiaxiaocheliang/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: 'System homepage',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: 'System homepage',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: 'update password',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: 'pay',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: 'Personal Information',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: 'Driving School Information',
        component: news
      }
      ,{
	path: '/aboutus',
        name: 'About Us',
        component: aboutus
      }
      ,{
	path: '/fenpeijiaolian',
        name: 'Assign coach',
        component: fenpeijiaolian
      }
      ,{
	path: '/yuyuelianxi',
        name: 'Appointment Practice',
        component: yuyuelianxi
      }
      ,{
	path: '/xueyuan',
        name: 'student',
        component: xueyuan
      }
      ,{
	path: '/kaoshianpai',
        name: 'Exam arrangements',
        component: kaoshianpai
      }
      ,{
	path: '/jiaxiaojiaolian',
        name: 'Driving school coach',
        component: jiaxiaojiaolian
      }
      ,{
	path: '/jiaofeixinxi',
        name: 'Payment information',
        component: jiaofeixinxi
      }
      ,{
	path: '/jiaolianpingjia',
        name: 'coach',
        component: jiaolianpingjia
      }
      ,{
	path: '/systemintro',
        name: 'System Introduction',
        component: systemintro
      }
      ,{
	path: '/xuexijihua',
        name: 'study plan',
        component: xuexijihua
      }
      ,{
	path: '/cheliangweihu',
        name: 'Vehicle maintenance',
        component: cheliangweihu
      }
      ,{
	path: '/jiaxiaobaoming',
        name: 'Registration for Driving School',
        component: jiaxiaobaoming
      }
      ,{
	path: '/jiaxiaocheliang',
        name: 'Driving school vehicles',
        component: jiaxiaocheliang
      }
      ,{
	path: '/config',
        name: 'Carousel management',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: 'System homepage',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//modifyold 型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
