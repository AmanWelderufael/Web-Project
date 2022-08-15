<template>
  <div class="card">
    <img :src="getImageURL(landmark.landmark_id)" />

    <div class="landmark">
      <h3 class="button ribbon">{{ landmark.landmark_name }}</h3>
    </div>

    <div class="info">
      <p>{{ landmark.landmark_description }}</p>
      <div id="button-container">
        <div v-if="$store.state.token != '' && this.itineraries.length != 0">
          <button type="button" class="btn" @click="showModal">
            Add to Itinerary
          </button>

          <Modal
            v-bind:landmark="landmark"
            v-show="isModalVisible"
            @close="closeModal"
          >
          </Modal>
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
import ItineraryService from "../services/ItineraryService";
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
  created() {
    ItineraryService.search().then((response) => {
      this.itineraries = response.data;
    });
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  font-family: sans-serif;
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
  background: rgb(255, 255, 255);
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

  border-radius: 20px;
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
  border-radius: 20px;
}

.card .info {
  position: relative;
  z-index: 3;
  color: rgb(255, 255, 255);
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
  background: rgb(255, 255, 255);
  color: #000;
  font-size: 15px;
  font-weight: bold;
  cursor: pointer;
  transition: 0.4s ease-in-out;
}
.card .info .btn:hover {
  box-shadow: 0px 7px 10px rgba(0, 0, 0, 0.5);
}

.ribbon {
  border-top-style: solid;
border-bottom-style: solid;
border-bottom-width: 1px;
  color: white;
  font-size: 25px;
  text-shadow: 0.05em 0 black, 0 0.05em black, -0.05em 0 black, 0 -0.05em black,
    -0.05em -0.05em black, -0.05em 0.05em black, 0.05em -0.05em black,
    0.05em 0.05em black;

  border-width: 2px 0;
  position: relative;
  display: block;
  padding: 0.75em 0 0.75em 0.5em;

  font-weight: bold;
}
</style>