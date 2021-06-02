create Table exercise (
                          exercise_id serial NOT NULL PRIMARY KEY,
                          title character varying(64) NOT NULL,
                          difficulty character varying(64) NOT NULL,
                          creator character varying(64) NOT NULL,
                          video_length integer Not NULL,
                          description character varying(64) NOT NULL
)