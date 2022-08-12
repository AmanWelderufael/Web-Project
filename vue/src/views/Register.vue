<template>
  <div id="register" class="text-center">
    <section id= "container">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account</button>

      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      
      
    </form>
    </section>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>

#register.text-center{
  margin: 0;
padding: 0;
box-sizing: border-box;
 background-image:url("../assets/18.jpg") ;
 background-size: cover;
 background-position:center center;
 display: flex;
 display: flex;
  width: 100%;
  height: 80vh;
  justify-content: center;
  align-items: center;
}
.form-register{
  position:absolute;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  background: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3));
  width: 380px;
  padding: 50px 30px;
  border-radius: 10px;
  box-shadow:7px 7px 60px #000;
  display: flex;
  flex-direction: column;
}

h1{
   text-transform: uppercase;
  font-size: 2em;
  text-align: center;
  margin-bottom: 2em;
}
.form-register input{
   width: 100%;
  display: block;
  padding: 10px;
  color: #222;
  border: none;
  outline: none;
  margin: 1em 0;
}
 .form-register input[type="submit"]{
  background:rgb(182, 7, 7);
  color:#fff;
  text-transform: uppercase;
  font-size: 1.2em;
  opacity: .8;
}



</style>
