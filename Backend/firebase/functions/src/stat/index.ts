/* eslint-disable object-curly-spacing */
/* eslint-disable max-len */
/* eslint-disable indent */
import { firestore } from "firebase-admin";
import * as admin from "firebase-admin";
import * as functions from "firebase-functions";

interface Measure {
    field: string;
    transform?: "negate";
    op: "avg" | "sum" | "count" | "num";
}

// <a> <op> <b>
// where a must be a field and b a corresponding value
// ex. $correct > 9
interface Filter {
    a: string;
    op: admin.firestore.WhereFilterOp;
    b: any;
}

interface QueryStatsBody {
    measures: Measure[];
    dimensions: string[];
    groupBy: string;
    filter?: Filter;
    collection: string;
    limit?: number;
}
/*
Query example
[{
    field: 'correct',
    op: 'sum',
}, {
    field: 'incorrect',
    op: 'sum',
}] - measure
['quizName'] - dimension
'timestamp' - groupBy
{a: '$type', op: '=', b: 'quizCompleted'}

Logic is as follows:
Data is ordered in asc order by the group by property
Each measure creates a unique data point
Every data point is grouped and ordered by the group by property,
where each dimension creates a data point group. If more than one dimension
is specified, "dimension groups" are generated with every possible combination
of the available dimensions. This should result in the following tree:
{
        group1: {
            dimension1: {dataPoint1: x, dataPoint2: y},
            dimension2: {dataPoint1: x, dataPoint2: y}
        },
        group2: {
            dimension1: {dataPoint1: x, dataPoint2: y},
            dimension2: {dataPoint1: x, dataPoint2: y}
        },
        ...
        group100: {
            dimension1: {dataPoint1: x, dataPoint2: y},
            dimension2: {dataPoint1: x, dataPoint2: y}
        }
    }
}

First we fetch all of the documents in the collection applying
filters and limit at this stage. Then we build the tree from
the outside in
*/

export const queryStats = functions.https.onCall(
    async (data: QueryStatsBody, context) => {
        if (!context.auth || !context.auth.token.admin) {
            return { error: "Forbidden" };
        }

        let query: admin.firestore.Query = admin.firestore().collection(data.collection);
        if (data.filter) {
            query = query.where(data.filter.a, data.filter.op, data.filter.b);
        }
        if (data.limit) {
            query = query.limit(data.limit);
        }

        const snap = await query.get();
        const res = snap.docs.map((a) => a.data()).reduce((res, doc) => {
            let key = doc[data.groupBy];
            if (data.groupBy === "timestamp") {
                key = (doc[data.groupBy] as admin.firestore.Timestamp)
                    .toDate()
                    .toDateString();
            }

            res[key] = res[key] || [];
            res[key].push(doc);
            return res;
        }, {});

        for (const k in res) {
            // process dimensions and reduce
        }

        return { error: "not implemented" };
        // return { status: 'ok', data: res }
    });
