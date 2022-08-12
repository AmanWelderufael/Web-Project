<template>
  <div id="login" class="text-center">
    <section id= "container">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
       <button  class="submit1" type="submit">Sign in</button>

      <p ></p> <router-link class="account" v-bind:to="{ name: 'register' }">Create an account</router-link>
      
     
    </form>
    </section>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>

#login.text-center{
margin: 0;
padding: 0;
box-sizing: border-box;
 background-image:url("../assets/17.jpg") ;
 background-size: cover;
 background-position:center center;

 display: flex;


}
div{
  display: flex;
  width: 100%;
  height: 100vh;
  justify-content: center;
  align-items: center;
}
.form-signin{
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
.form-signin input{
  width: 100%;
  display: block;
  padding: 10px;
  color: #222;
  border: none;
  outline: none;
  margin: 1em 0;
}
.form-signin input[type="submit"]{
  background:rgb(182, 7, 7);
  color:#fff;
  text-transform: uppercase;
  font-size: 1.2em;
  opacity: .8;
}

.account{
   color: rgb(72, 124, 221);
   font-family: Arial, Helvetica, sans-serif;
  
}
.submit1{

  background: rgb(1, 14, 22);
  color:#fff;
  text-transform: uppercase;
  font-size: 1.2em;
  opacity: .8;
  color: rgb(245, 237, 244);
  border:none;
}

</style>
