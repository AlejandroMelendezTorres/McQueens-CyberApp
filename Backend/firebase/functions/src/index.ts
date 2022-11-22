import * as admin from "firebase-admin";
import * as functions from "firebase-functions";

admin.initializeApp(functions.config().firebase);

export { createUser } from "./users/createUser";
export { queryStats } from "./stat/index";

