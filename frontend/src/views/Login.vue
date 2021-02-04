<template>
    <section class="section section-shaped section-lg my-0">
        <div class="shape shape-style-1 bg-gradient-default">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div class="container pt-lg-md">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                    <card type="secondary" shadow
                          header-classes="bg-white pb-5"
                          body-classes="px-lg-5 py-lg-5"
                          class="border-0">
                        <template>
                            <div class="text-muted text-center mb-3">
                                <small>로그인</small>
                            </div>
                            <div class="btn-wrapper text-center">
                                <base-button type="neutral">
                                    <img slot="icon" src="img/icons/common/github.svg">
                                    Github
                                </base-button>

                                <base-button type="neutral">
                                    <img slot="icon" src="img/icons/common/google.svg">
                                    Google
                                </base-button>
                            </div>
                        </template>
                        <template>
                            <div class="text-center text-muted mb-4">
                                <small>ID/PW 로그인</small>
                            </div>
                            <form name="form" @submit.prevent="handleLogin">
                                <div class="form-group">
                                <label for="email">Email</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    name="email"
                                    v-model="user.email"
                                    v-validate="'required'"
                                />
                                <div
                                    class="alert alert-danger"
                                    role="alert"
                                    v-if="errors.has('email')"
                                >Email is required!</div>
                                </div>
                                <div class="form-group">
                                <label for="username">Username</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    name="username"
                                    v-model="user.username"
                                    v-validate="'required'"
                                />
                                <div
                                    class="alert alert-danger"
                                    role="alert"
                                    v-if="errors.has('username')"
                                >Username is required!</div>
                                </div>
                                <div class="form-group">
                                <label for="password">Password</label>
                                <input
                                    type="password"
                                    class="form-control"
                                    name="password"
                                    v-model="user.password"
                                    v-validate="'required'"
                                />
                                <div
                                    class="alert alert-danger"
                                    role="alert"
                                    v-if="errors.has('password')"
                                >Password is required!</div>
                                </div>
                                <div class="form-group">
                                <button class="btn btn-primary btn-block" :disabled="loading">
                                    <span class="spinner-border spinner-border-sm" v-show="loading"></span>
                                    <span>Login</span>
                                </button>
                                </div>
                                <div class="form-group">
                                <div class="alert alert-danger" role="alert" v-if="message">{{message}}</div>
                                </div>
                            </form>
                        </template>
                    </card>
                    <div class="row mt-3">
                        <div class="col-6">
                            <a href="#" class="text-light">
                                <small>Forgot password?</small>
                            </a>
                        </div>
                        <div class="col-6 text-right">
                            <a href="#" class="text-light">
                                <small>Create new account</small>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>
<script>
export default {
  name: 'login',
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn
    }
  },
  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/')
    }
  },
  methods: {
    handleLogin() {
      this.loading = true
      this.$validator.validateAll()

      if (this.errors.any()) {
        this.loading = false
        return
      }

      if (this.user.email && this.user.username && this.user.password) {
        this.$store.dispatch('auth/login', this.user).then(
          () => {
            this.$router.push('/profile')
          },
          error => {
            this.loading = false
            this.message = error.message
          }
        )
      }
    }
  }
};
</script>
<style>
</style>
