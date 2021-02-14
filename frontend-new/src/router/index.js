import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/Login/Login'
import Register from '@/views/Register/Register'
import Goldspoon from '@/views/Goldspoon/Goldspoon'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      meta: { unauthorized: true }
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },
    {
      path: "/register",
      name: "register",
      component: Register
    },
    {
      path: "/goldspoon",
      name: "goldspoon",
      component: Goldspoon
    },
  ]
})
