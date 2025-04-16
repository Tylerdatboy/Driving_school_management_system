import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueyuanList from '../pages/xueyuan/list'
import xueyuanDetail from '../pages/xueyuan/detail'
import xueyuanAdd from '../pages/xueyuan/add'
import jiaxiaojiaolianList from '../pages/jiaxiaojiaolian/list'
import jiaxiaojiaolianDetail from '../pages/jiaxiaojiaolian/detail'
import jiaxiaojiaolianAdd from '../pages/jiaxiaojiaolian/add'
import fenpeijiaolianList from '../pages/fenpeijiaolian/list'
import fenpeijiaolianDetail from '../pages/fenpeijiaolian/detail'
import fenpeijiaolianAdd from '../pages/fenpeijiaolian/add'
import yuyuelianxiList from '../pages/yuyuelianxi/list'
import yuyuelianxiDetail from '../pages/yuyuelianxi/detail'
import yuyuelianxiAdd from '../pages/yuyuelianxi/add'
import jiaxiaocheliangList from '../pages/jiaxiaocheliang/list'
import jiaxiaocheliangDetail from '../pages/jiaxiaocheliang/detail'
import jiaxiaocheliangAdd from '../pages/jiaxiaocheliang/add'
import kaoshianpaiList from '../pages/kaoshianpai/list'
import kaoshianpaiDetail from '../pages/kaoshianpai/detail'
import kaoshianpaiAdd from '../pages/kaoshianpai/add'
import xuexijihuaList from '../pages/xuexijihua/list'
import xuexijihuaDetail from '../pages/xuexijihua/detail'
import xuexijihuaAdd from '../pages/xuexijihua/add'
import jiaofeixinxiList from '../pages/jiaofeixinxi/list'
import jiaofeixinxiDetail from '../pages/jiaofeixinxi/detail'
import jiaofeixinxiAdd from '../pages/jiaofeixinxi/add'
import cheliangweihuList from '../pages/cheliangweihu/list'
import cheliangweihuDetail from '../pages/cheliangweihu/detail'
import cheliangweihuAdd from '../pages/cheliangweihu/add'
import jiaxiaobaomingList from '../pages/jiaxiaobaoming/list'
import tableList from '../pages/table/list'
import tableadd from '../pages/table/add'
import jiaxiaobaomingDetail from '../pages/jiaxiaobaoming/detail'
import jiaxiaobaomingAdd from '../pages/jiaxiaobaoming/add'
import jiaolianpingjiaList from '../pages/jiaolianpingjia/list'
import jiaolianpingjiaDetail from '../pages/jiaolianpingjia/detail'
import jiaolianpingjiaAdd from '../pages/jiaolianpingjia/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xueyuan',
					component: xueyuanList
				},
				{
					path: 'xueyuanDetail',
					component: xueyuanDetail
				},
				{
					path: 'xueyuanAdd',
					component: xueyuanAdd
				},
				{
					path: 'jiaxiaojiaolian',
					component: jiaxiaojiaolianList
				},
				{
					path: 'jiaxiaojiaolianDetail',
					component: jiaxiaojiaolianDetail
				},
				{
					path: 'jiaxiaojiaolianAdd',
					component: jiaxiaojiaolianAdd
				},
				{
					path: 'fenpeijiaolian',
					component: fenpeijiaolianList
				},
				{
					path: 'fenpeijiaolianDetail',
					component: fenpeijiaolianDetail
				},
				{
					path: 'fenpeijiaolianAdd',
					component: fenpeijiaolianAdd
				},
				{
					path: 'yuyuelianxi',
					component: yuyuelianxiList
				},
				{
					path: 'yuyuelianxiDetail',
					component: yuyuelianxiDetail
				},
				{
					path: 'yuyuelianxiAdd',
					component: yuyuelianxiAdd
				},
				{
					path: 'jiaxiaocheliang',
					component: jiaxiaocheliangList
				},
				{
					path: 'jiaxiaocheliangDetail',
					component: jiaxiaocheliangDetail
				},
				{
					path: 'jiaxiaocheliangAdd',
					component: jiaxiaocheliangAdd
				},
				{
					path: 'kaoshianpai',
					component: kaoshianpaiList
				},
				{
					path: 'kaoshianpaiDetail',
					component: kaoshianpaiDetail
				},
				{
					path: 'kaoshianpaiAdd',
					component: kaoshianpaiAdd
				},
				{
					path: 'xuexijihua',
					component: xuexijihuaList
				},
				{
					path: 'xuexijihuaDetail',
					component: xuexijihuaDetail
				},
				{
					path: 'xuexijihuaAdd',
					component: xuexijihuaAdd
				},
				{
					path: 'jiaofeixinxi',
					component: jiaofeixinxiList
				},
				{
					path: 'jiaofeixinxiDetail',
					component: jiaofeixinxiDetail
				},
				{
					path: 'jiaofeixinxiAdd',
					component: jiaofeixinxiAdd
				},
				{
					path: 'cheliangweihu',
					component: cheliangweihuList
				},
				{
					path: 'cheliangweihuDetail',
					component: cheliangweihuDetail
				},
				{
					path: 'cheliangweihuAdd',
					component: cheliangweihuAdd
				},
				{
					path: 'jiaxiaobaoming',
					component: jiaxiaobaomingList
				},
				{
					path: 'jiaxiaobaomingDetail',
					component: jiaxiaobaomingDetail
				},
				{
					path: 'jiaxiaobaomingAdd',
					component: jiaxiaobaomingAdd
				},{
					path: 'tableList',
					component: tableList
				},,{
					path: 'tableadd',
					component: tableadd
				},
				{
					path: 'jiaolianpingjia',
					component: jiaolianpingjiaList
				},
				{
					path: 'jiaolianpingjiaDetail',
					component: jiaolianpingjiaDetail
				},
				{
					path: 'jiaolianpingjiaAdd',
					component: jiaolianpingjiaAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
