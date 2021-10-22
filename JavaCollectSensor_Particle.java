/**
 * This method returns the raw sensor particle data (PM2.5) of the specified type.
 *
 * @param index specifies the data index (not used).
 * @param dataType specifies the data type.
 * @return raw sensor data of the specified index and type.
 */

@Override
public SensorData<Double> getRawData(int index, DataType dataType)
{
    final String funcName = "getRawData";
    SensorData<Double> data = null;

    switch (dataType)
    {
        case Particle:
            data = new SensorData<>(TrcUtil.getCurrentTime(), sensor.getParticleConcentration());
            break;
    }

    if (debugEnabled)
    {
        dbgTrace.traceEnter(funcName, TrcDbgTrace.TraceLevel.API);
        dbgTrace.traceExit(funcName, TrcDbgTrace.TraceLevel.API,
                           "=(timestamp:%.3f,value=%f)", data.timestamp, data.value);
    }

    return data;
}