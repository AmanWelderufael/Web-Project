<template>
  <div id="gridContainer">
    <div class="card gridItem" style="width: 20rem">
      <div class="card-body">
        <h5 class="card-title">{{ landmark.landmark_name }}</h5>
        <p id="description" class="card-text">
          {{ landmark.landmark_description }}
        </p>
        <p class="card-text">review-1</p>
        <p class="card-text">review-2</p>
        <a href="#" class="card-link">Add to Itinerary</a>
      </div>
    </div>

    <img
      class="gridItem"
      id="landmark-picture"
      :src="getImageURL(landmark.landmark_id)"
    />

    <the-map v-bind:landmark="landmark" class="gridItem" id="map"></the-map>
  </div>
</template>

<script>
import LandmarkService from "../services/LandmarkService";
import TheMap from "../components/map.vue";

export default {
  name: "landmark-details",

  data() {
    return {
      landmark: "",
    };
  },
  components: {
    TheMap,
  },
  created() {
    LandmarkService.getByID(this.$route.params.id).then((response) => {
      this.landmark = response.data;
    });
  },
  methods: {
    getImageURL(id) {
      console.log("../assets/" + id + ".jpg");
      return require("../assets/" + id + ".jpg");
    },
  },
};
</script>

<style scoped>
.card {
  grid-area: description;
  height: 90%;
  background: linear-gradient(
    to bottom,
    rgba(0, 59, 176, 0.5),
    rgb(61, 171, 201)
  );
}

.card-body {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 100%;
}
.card-title {
  font-weight: bold;
  font-size: 100%;
}
#name {
  font-weight: bold;
  font-size: 400%;
  grid-area: name;
}
#description {
  grid-area: description;
  font-size: 80%;
}
#landmark-picture {
  grid-area: picture;
  width: 90%;
  height: 90%;
  object-fit: cover;
}
#map {
  grid-area: map;
  width: 30%;
  height: auto;
  width: auto;
}
.gridItem {
  box-shadow: 0px 7px 10px rgba(0, 0, 0, 0.5);
}

.textBox {
  background: linear-gradient(
    to bottom,
    rgba(0, 176, 155, 0.5),
    rgba(150, 201, 61, 1)
  );
}

#gridContainer {
  display: grid;
  grid-template-columns: 3fr 1fr 2fr;
  grid-template-areas:
    "picture description map"
    "picture description map"
    "picture description map";
  gap: 20px;
  column-gap: 30px;
  background-color: #143050;
  height: 85vh;
  place-items: center;
}
#description {
  padding-left: 80px;
  padding-right: 80px;
  font-size: 20px;
  margin: auto;
}

@media screen and (max-width: 1024px) {
  #gridContainer {
    grid-template-columns: 1fr 1fr;
    row-gap: 20px;
    column-gap: 35px;
    grid-template-areas:
      "picture description"
      "map map";
  }

  @media screen and (max-width: 450px) {
    #gridContainer {
      grid-template-columns: 1fr;
      grid-template-areas:
        "picture"
        "description"
        "map";
      align-items: center;
    }
  }
}
</style>