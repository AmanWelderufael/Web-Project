<template>
  <div class="card">
    <img :src="getImageURL(landmark.landmark_id)" />

    <div class="makeRibbon">
      <h3 class="button ribbon">{{ landmark.landmark_name }}</h3>
    </div>

    <div class="info">
      <p>{{ landmark.landmark_description }}</p>
      <div id="button-container">
        <div
          v-if="$store.state.token != '' && this.itineraries.length != 0"
          
        >
          <button type="button" class="btn" @click="showModal">
            Add to Itinerary
          </button>

          <Modal v-bind:landmark ="landmark" v-show="isModalVisible" @close="closeModal"> </Modal>
        </div>

        <router-link
          class="btn"
          v-bind:to="{
            name: 'Landmark-details',
            params: { id: landmark.landmark_id },
          }"
          >Details</router-link
        >
      </div>
    </div>
  </div>

  <!-- <img :src="getImageURL(landmark.landmark_id)">
      
      
          <h5 class = "card-title">{{landmark.landmark_name}}</h5>
          <p class = "card-text">{{landmark.landmark_description}}</p>
       -->
</template>






<script>
import Modal from "../components/itineraryModal.vue";
import ItineraryService from '../services/ItineraryService';
export default {
  components: {
    Modal,
  },
  props: {
    landmark: Object,
  },
  data() {
    return {
      isModalVisible: false,
      itineraries: [],
      selectedItinerary: "",
    };
  },

  methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    },
    showModal() {
      this.isModalVisible = true;
    },
    closeModal() {
      this.isModalVisible = false;
    },
  },
  created(){
    ItineraryService.search().then( response => {
       this.itineraries = response.data;
    })
  }
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  font-family: "Lato", sans-serif;
}
html,
body {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #222;
}
#button-container {
  display: flex;
  justify-content: space-around;
}
.wrapper {
  /* display: flex;
  width: 70%;
  justify-content: space-around; */
}
.card {
  width: 100%;
  height: 100%;
  padding: 2rem 1rem;
  background: #fff;
  position: relative;
  display: flex;
  align-items: flex-end;
  box-shadow: 0px 7px 10px rgba(0, 0, 0, 0.5);
  transition: 0.5s ease-in-out;
}
.card:hover {
  transform: translateY(20px);
}
.card:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    to bottom,
    rgba(0, 176, 155, 0.5),
    rgba(150, 201, 61, 1)
  );
  z-index: 2;
  transition: 0.5s all;
  opacity: 0;
}
.card:hover:before {
  opacity: 1;
}

.card img {
  float: left;
  width: 100%;
  height: 100%;
  object-fit: cover;
  position: absolute;
  top: 0;
  left: 0;
}

.card .info {
  position: relative;
  z-index: 3;
  color: #fff;
  opacity: 0;
  transform: translateY(30px);
  transition: 0.5s all;
}
.card:hover .info {
  opacity: 1;
  transform: translateY(0px);
}
.card .info h1 {
  margin: 0;
}
.card .info p {
  letter-spacing: 1px;
  font-size: 15px;
  margin-top: 8px;
  margin-bottom: 20px;
}
.card .info .btn {
  text-decoration: none;
  padding: 0.5rem 1rem;
  background: #fff;
  color: #000;
  font-size: 14px;
  font-weight: bold;
  cursor: pointer;
  transition: 0.4s ease-in-out;
}
.card .info .btn:hover {
  box-shadow: 0px 7px 10px rgba(0, 0, 0, 0.5);
}

.makeRibbon {
  font-family: futura;
  color: white;

  text-align: center;
  margin: 2em auto 4em;
  max-width: 600px;
}

h3 {
  text-decoration: none;
  color: rgb(10, 3, 9);
  overflow: hidden;
  display: block;
  margin: 0.75em;
}

.button {
  letter-spacing: 0.5em;
  text-decoration: center;
  padding: 0.75em 1.25em 0.75em 1.75em;
  border-color: white;
  border-width: 2px;
  border-style: solid;
  white-space: nowrap;
  -webkit-transition: border-color 500ms ease, color 250ms ease;
  -moz-transition: border-color 500ms ease, color 250ms ease;
  -ms-transition: border-color 500ms ease, color 250ms ease;
  -o-transition: border-color 500ms ease, color 250ms ease;
  transition: border-color 500ms ease, color 250ms ease;
}

.ribbon {
  border-width: 2px 0;
  position: relative;
  display: block;
  padding: 0.75em 0 0.75em 0.5em;
}

.ribbon:before {
  content: "";
  display: inline-block;
  border-bottom-width: 2px;
  border-left-width: 2px;
  -webkit-transform: rotate(-135deg);
  -moz-transform: rotate(-135deg);
  -ms-transform: rotate(-135deg);
  -o-transform: rotate(-135deg);
  transform: rotate(-135deg);
  -webkit-transform-origin: 0% 100%;
  -moz-transform-origin: 0% 100%;
  -ms-transform-origin: 0% 100%;
  -o-transform-origin: 0% 100%;
  transform-origin: 0% 100%;
  position: absolute;
  top: -50%;
  bottom: 50%;
  left: 1.6em;
  right: 0;
}

.ribbon:after {
  content: "";
  display: inline-block;
  border-bottom-width: 2px;
  border-right-width: 2px;
  -webkit-transform: rotate(135deg);
  -moz-transform: rotate(135deg);
  -ms-transform: rotate(135deg);
  -o-transform: rotate(135deg);
  transform: rotate(135deg);
  -webkit-transform-origin: 100% 100%;
  -moz-transform-origin: 100% 100%;
  -ms-transform-origin: 100% 100%;
  -o-transform-origin: 100% 100%;
  transform-origin: 100% 100%;
  position: absolute;
  top: -50%;
  bottom: 50%;
  left: 0;
  right: 1.6em;
}
</style>