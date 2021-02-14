<template>
  <div id="app">
      <the-layout>
        <router-view />
      </the-layout>
  </div>
</template>
<script>

import TheLayout from '@/layouts/TheLayout'

export default {
    name: 'App',
    components: { TheLayout },
    computed: {
      currentUser () {
        return this.$store.state.auth.user
      }
    },
    methods: {
      logOut () {
        this.$store.dispatch('auth/logout')
        this.$router.push('/')
      }
    }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
